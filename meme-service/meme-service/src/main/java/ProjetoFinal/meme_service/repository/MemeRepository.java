package ProjetoFinal.meme_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoFinal.meme_service.entity.Meme;

public interface MemeRepository
        extends JpaRepository<Meme, Long> {
}
