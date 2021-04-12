package desafio.desafio.modulo.servicoproduto.service;

import desafio.desafio.modulo.servicoproduto.model.ServicoProduto;
import desafio.desafio.modulo.servicoproduto.repository.ServicoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicoProdutoService {

    @Autowired
    ServicoProdutoRepository servicoProdutoRepository;

    public ServicoProduto cadastraServicoProduto( ServicoProduto servicoProduto){
        return servicoProdutoRepository.save(servicoProduto);
    }

    public ServicoProduto editaServicoProduto(ServicoProduto servicoProduto){
        if(servicoProduto.getId() == null){
            throw new NullPointerException();
        }else{
            return servicoProdutoRepository.save(servicoProduto);
        }

    }

    public void desativaServicoProduto(UUID id){
        ServicoProduto sp = servicoProdutoRepository.getById(id);
        sp.setEstado(false);
        servicoProdutoRepository.save(sp);
    }

    public List<ServicoProduto> resgataTodos(){
        return (List<ServicoProduto>) servicoProdutoRepository.findAll();
    }

    public Page<ServicoProduto> paginacaoServivoProduto(Pageable pageable){
        return servicoProdutoRepository.findAll(pageable);
    }
}
