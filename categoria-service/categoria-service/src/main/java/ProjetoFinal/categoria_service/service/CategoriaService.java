package ProjetoFinal.categoria_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import ProjetoFinal.categoria_service.dto.CategoriaRequestDTO;
import ProjetoFinal.categoria_service.dto.CategoriaResponseDTO;
import ProjetoFinal.categoria_service.entity.CategoriaMeme;
import ProjetoFinal.categoria_service.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(
            CategoriaRepository repository) {

        this.repository = repository;
    }

    public CategoriaResponseDTO criarCategoria(
            CategoriaRequestDTO dto) {

        CategoriaMeme categoria = new CategoriaMeme();

        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());
        categoria.setUsuarioId(dto.getUsuarioId());
        categoria.setDataCadastro(LocalDate.now());

        CategoriaMeme salva =
                repository.save(categoria);

        return converterParaDTO(salva);
    }

    public List<CategoriaResponseDTO> listarCategorias() {

        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public CategoriaResponseDTO buscarPorId(Long id) {

        CategoriaMeme categoria =
                repository.findById(id)
                        .orElseThrow(
                                () -> new CategoriaNaoEncontradaException(id)
                        );

        return converterParaDTO(categoria);
    }

    private CategoriaResponseDTO converterParaDTO(
            CategoriaMeme categoria) {

        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao(),
                categoria.getDataCadastro(),
                categoria.getUsuarioId()
        );
    }
}
