package ProjetoFinal.meme_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import ProjetoFinal.meme_service.dto.MemeRequestDTO;
import ProjetoFinal.meme_service.dto.MemeResponseDTO;
import ProjetoFinal.meme_service.entity.Meme;
import ProjetoFinal.meme_service.repository.MemeRepository;
import br.com.ebac.memeservice.exception.MemeNaoEncontradoException;

@Service
public class MemeService {

    private final MemeRepository repository;

    public MemeService(MemeRepository repository) {
        this.repository = repository;
    }

    public MemeResponseDTO criarMeme(MemeRequestDTO dto) {

        Meme meme = new Meme();

        meme.setNome(dto.getNome());
        meme.setDescricao(dto.getDescricao());
        meme.setUsuarioId(dto.getUsuarioId());
        meme.setCategoriaId(dto.getCategoriaId());
        meme.setDataCadastro(LocalDate.now());

        Meme salvo = repository.save(meme);

        return converterParaDTO(salvo);
    }

    public List<MemeResponseDTO> listarMemes() {

        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public MemeResponseDTO buscarPorId(Long id) {

        Meme meme = repository.findById(id)
                .orElseThrow(
                        () -> new MemeNaoEncontradoException(id)
                );

        return converterParaDTO(meme);
    }

    private MemeResponseDTO converterParaDTO(Meme meme) {

        return new MemeResponseDTO(
                meme.getId(),
                meme.getNome(),
                meme.getDescricao(),
                meme.getDataCadastro(),
                meme.getUsuarioId(),
                meme.getCategoriaId()
        );
    }
}
