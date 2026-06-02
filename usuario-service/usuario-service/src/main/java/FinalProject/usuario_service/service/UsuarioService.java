package FinalProject.usuario_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import FinalProject.usuario_service.dto.UsuarioRequestDTO;
import FinalProject.usuario_service.entity.Usuario;
import FinalProject.usuario_service.exception.EmailJaCadastradoException;
import FinalProject.usuario_service.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {

        if (repository.existsByEmail(dto.getEmail())) {
            throw new EmailJaCadastradoException(dto.getEmail());
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setDataCadastro(LocalDate.now());

        Usuario salvo = repository.save(usuario);

        return converterParaDTO(salvo);
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public UsuarioResponseDTO buscarPorId(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));

        return converterParaDTO(usuario);
    }

    private UsuarioResponseDTO converterParaDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataCadastro()
        );
    }
}
