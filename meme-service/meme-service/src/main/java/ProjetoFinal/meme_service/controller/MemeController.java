package ProjetoFinal.meme_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ProjetoFinal.meme_service.dto.MemeRequestDTO;
import ProjetoFinal.meme_service.dto.MemeResponseDTO;
import ProjetoFinal.meme_service.service.MemeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/memes")
public class MemeController {

    private final MemeService service;

    public MemeController(MemeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MemeResponseDTO criarMeme(
            @Valid @RequestBody MemeRequestDTO dto) {

        return service.criarMeme(dto);
    }

    @GetMapping
    public List<MemeResponseDTO> listarMemes() {
        return service.listarMemes();
    }

    @GetMapping("/{id}")
    public MemeResponseDTO buscarPorId(
            @PathVariable Long id) {

        return service.buscarPorId(id);
    }
}
