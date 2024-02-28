package edu.ucan.BancoBci.service;

import edu.ucan.BancoBci.entities.EstadoCivilEntity;

import java.util.List;
import java.util.UUID;

public interface EstadoCivilService {

    public List<EstadoCivilEntity> listarEstadoCivil();
    public EstadoCivilEntity  salvar(String descricao);

    public  void eliminarEstadoCivil(UUID id);

    public  EstadoCivilEntity buscarPorIdEstadoCivil(UUID k) ;

    public void atualizarEstadoCivil(UUID k, String descricao);

}
