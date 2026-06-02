package ProjetoFinal.categoria_service.dto;

import java.time.LocalDate;

public class CategoriaResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataCadastro;
    private Long usuarioId;

    public CategoriaResponseDTO(
            Long id,
            String nome,
            String descricao,
            LocalDate dataCadastro,
            Long usuarioId) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.usuarioId = usuarioId;
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
}
