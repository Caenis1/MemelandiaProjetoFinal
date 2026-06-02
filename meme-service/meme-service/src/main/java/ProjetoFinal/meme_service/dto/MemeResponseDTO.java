package ProjetoFinal.meme_service.dto;

import java.time.LocalDate;

public class MemeResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataCadastro;
    private Long usuarioId;
    private Long categoriaId;

    public MemeResponseDTO(
            Long id,
            String nome,
            String descricao,
            LocalDate dataCadastro,
            Long usuarioId,
            Long categoriaId) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.usuarioId = usuarioId;
        this.categoriaId = categoriaId;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }
}
