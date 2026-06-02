package ProjetoFinal.categoria_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ProjetoFinal.categoria_service.dto.CategoriaRequestDTO;
import ProjetoFinal.categoria_service.dto.CategoriaResponseDTO;
import ProjetoFinal.categoria_service.service.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(
            CategoriaService service) {

        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaResponseDTO criarCategoria(
            @Valid @RequestBody CategoriaRequestDTO dto) {

        return service.criarCategoria(dto);
    }

    @GetMapping
    public List<CategoriaResponseDTO> listarCategorias() {
        return service.listarCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaResponseDTO buscarPorId(
            @PathVariable Long id) {

        return service.buscarPorId(id);
    }
}
