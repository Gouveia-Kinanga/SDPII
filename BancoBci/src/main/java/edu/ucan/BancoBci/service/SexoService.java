package edu.ucan.BancoBci.service;

import edu.ucan.BancoBci.entities.SexoEntity;

import java.util.List;
import java.util.UUID;

public interface SexoService {

    public List<SexoEntity> listarSexo();
    public SexoEntity  salvar(String descricao );

    public  void eliminarSexo(UUID id);

    public SexoEntity buscarPorIdSexo(UUID k);

    public void atualizarSexo(UUID k, String descricso );

}
