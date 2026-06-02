package ProjetoFinal.categoria_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoFinal.categoria_service.entity.CategoriaMeme;

public interface CategoriaRepository
        extends JpaRepository<CategoriaMeme, Long> {
}
