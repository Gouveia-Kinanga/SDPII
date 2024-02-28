package edu.ucan.BancoBci.service;

import edu.ucan.BancoBci.entities.LocalidadeEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LocalidadeService {
    public List<LocalidadeEntity> listarLocalidade();
    public LocalidadeEntity  salvar(String descricao, UUID idLocalidadePai );

    public  void eliminarLocalidade(UUID id);

    public LocalidadeEntity buscarPorIdLocalidade(UUID k);

    public void atualizarLocalidade(UUID k, String descricao, UUID idLocalidadePai  );

   LocalidadeEntity  buscarLocalidadePelaDescricao(String  descricao);
}
