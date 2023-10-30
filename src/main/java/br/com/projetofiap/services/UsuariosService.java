package br.com.projetofiap.services;

import br.com.projetofiap.dto.UsuariosDTO;
import br.com.projetofiap.exception.NegocioException;
import br.com.projetofiap.mapper.UsuarioMapper;
import br.com.projetofiap.model.Usuarios;
import br.com.projetofiap.repositories.SolicitacoesRepository;
import br.com.projetofiap.repositories.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuariosService {

    private final UsuarioMapper mapper;

    private final EmailService emailService;

    private final UsuariosRepository repository;
    private final SolicitacoesRepository solicitacoesRepository;

    @Transactional
    public UsuariosDTO gravar(UsuariosDTO usuariosDTO) {
        var usuario = this.mapper.mapToUsuario(usuariosDTO);
        usuario.setId(null);
        Optional<Usuarios> usuariosOptional = this.repository.findByCpf(usuario.getCpf());

        if (usuariosOptional.isPresent()) {
            throw new NegocioException("Usuário já cadastrado");
        }
        UsuariosDTO usuarioSalvo = this.mapper.mapToUsuariosDTO(this.repository.save(usuario));

        try {
            this.emailService.enviarEmail(usuarioSalvo.email(), "Cadastro criado com sucesso", templateEmail(usuarioSalvo.nome()));
        } catch (MailException e) {
            log.error("Falha ao enviar email", e);
        }

        return usuarioSalvo;
    }

    private String templateEmail(String nome) {
        String email = """
                        Olá %s, você foi incluído(a) na plataforma de abertura de chamados. \n
                        Caso precise de algum serviço da área de Tecnologia, você pode abrir a solicitação pelo nosso portal \n
                       
                        Obs: Não responder o email
                       """;

        return String.format(email, nome);
    }

    @Transactional
    public UsuariosDTO atualizar(UsuariosDTO usuariosDTO, Integer id) {
        Usuarios usuario = obterUsuario(id);

        Optional<Usuarios> usuariosOptional = this.repository.verificarUsuarioJahCadastrado(usuario.getCpf(), id);

        if (usuariosOptional.isPresent()) {
            usuario.setNome(usuariosDTO.nome());
            usuario.setCpf(usuariosDTO.cpf());
            usuario.setDataNascimento(usuariosDTO.dataNascimento());
            usuario.setPerfil(usuariosDTO.perfil());
        } else {
            throw new RuntimeException("Não é possível alterar o cpf do usuário");
        }

        return this.mapper.mapToUsuariosDTO(this.repository.save(usuario));
    }

    @Transactional
    public void deletar(Integer id) {
        Usuarios usuario = obterUsuario(id);

        var solicitacoesUsuario = this.solicitacoesRepository.obterSolicitacoesUsuario(usuario.getId());

        if (!solicitacoesUsuario.isEmpty()) {
            throw new NegocioException("O usuário não pode ser deletado");
        }

        this.repository.delete(usuario);
    }

    public UsuariosDTO obterUsuarioPorId(Integer id) {
        return this.mapper.mapToUsuariosDTO(this.obterUsuario(id));
    }

    private Usuarios obterUsuario(Integer id) {
        if (Objects.isNull(id) || id <= 0) {
            throw new NegocioException("ID inválido");
        }

        Optional<Usuarios> usuariosOptional = this.repository.findById(id);
        return usuariosOptional.orElseThrow(() -> new NegocioException("Usuário não localizado"));
    }

}
