package edu.ucan.BancoBic.service;

import edu.ucan.BancoBic.entities.TipoContaEntity;

import java.util.List;
import java.util.UUID;

public interface TipoContaService {

    public List<TipoContaEntity> listarTipoConta();
    public TipoContaEntity salvar(String descricao );

    public  void eliminarTipoConta(UUID id);

    public TipoContaEntity buscarPorIdTipoConta(UUID k);

    public void atualizarTipoConta(UUID k, String descricso );
}
