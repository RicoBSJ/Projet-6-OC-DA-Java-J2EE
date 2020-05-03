package com.aubrun.eric.projet6.consumer.DAO;

import java.util.List;

import com.aubrun.eric.projet6.model.bean.Client;

public interface ClientDao {

    void creer( Client client ) throws Exception;

    Client trouver( long id ) throws Exception;

    List<Client> lister() throws Exception;

    void supprimer( Client client ) throws Exception;
}