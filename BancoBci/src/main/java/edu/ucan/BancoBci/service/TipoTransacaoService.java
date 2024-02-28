package edu.ucan.BancoBci.service;

import edu.ucan.BancoBci.entities.TipoTransacaoEntity;


import java.util.List;
import java.util.UUID;

public interface TipoTransacaoService {
    public List<TipoTransacaoEntity> listarTipoTransacao();

    public TipoTransacaoEntity salvar(String descricao );

    public  void eliminarTipoTransacao(UUID id);

    public TipoTransacaoEntity buscarPorIdTipoTransacao(UUID k);

    public void atualizarTipoTransacao(UUID k, String descricao );
}
