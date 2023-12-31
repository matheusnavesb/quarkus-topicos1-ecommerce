package br.unitins.topicos1.ecommerce.service;

import java.util.ArrayList;
import java.util.List;


import br.unitins.topicos1.ecommerce.dto.EnderecoDTO;
import br.unitins.topicos1.ecommerce.dto.TelefoneDTO;
import br.unitins.topicos1.ecommerce.dto.UsuarioDTO;
import br.unitins.topicos1.ecommerce.dto.UsuarioResponseDTO;
import br.unitins.topicos1.ecommerce.model.Endereco;
import br.unitins.topicos1.ecommerce.model.Perfil;
import br.unitins.topicos1.ecommerce.model.Telefone;
import br.unitins.topicos1.ecommerce.model.Usuario;
import br.unitins.topicos1.ecommerce.repository.UsuarioRepository;
import br.unitins.topicos1.ecommerce.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    UsuarioRepository repository;

    @Inject
    HashService hashService;

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto) {

        if (repository.findByLogin(dto.login()) != null) {
            throw new ValidationException("login", "Login já existe.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setLogin(dto.login());

        novoUsuario.setSenha(hashService.getHashSenha(dto.senha()));
        novoUsuario.setCpf(dto.cpf());
        novoUsuario.setPerfil(Perfil.valueOf(dto.idPerfil()));

        if (dto.listaTelefone() != null && 
                    !dto.listaTelefone().isEmpty()){
            novoUsuario.setListaTelefone(new ArrayList<Telefone>());
            for (TelefoneDTO tel : dto.listaTelefone()) {
                Telefone telefone = new Telefone();
                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());
                novoUsuario.getListaTelefone().add(telefone);
            }
        }

        if(dto.listaEndereco() != null && !dto.listaTelefone().isEmpty()){
            novoUsuario.setListaEndereco(new ArrayList<Endereco>());
            for(EnderecoDTO end : dto.listaEndereco()){
                Endereco endereco = new Endereco();
                endereco.setRua(end.rua());
                endereco.setNumero(end.numero());
                endereco.setCidade(end.cidade());
                endereco.setEstado(end.estado());
                endereco.setCep(end.cep());
                novoUsuario.getListaEndereco().add(endereco);
            }
        }

        repository.persist(novoUsuario);

        return UsuarioResponseDTO.valueOf(novoUsuario);

    }

    @Override
    @Transactional
    public UsuarioResponseDTO update(UsuarioDTO dto, Long id) {
        Usuario usuario = repository.findById(id);

            usuario.setNome(dto.nome());
            usuario.setLogin(dto.login());
            usuario.setSenha(dto.senha());
            usuario.setCpf(dto.cpf());
    
            List<Telefone> telefones = new ArrayList<>();
                for (TelefoneDTO tel : dto.listaTelefone()) {
                    Telefone telefone = new Telefone();
                    telefone.setCodigoArea(tel.codigoArea());
                    telefone.setNumero(tel.numero());
                    telefones.add(telefone);
        }
            List<Endereco> enderecos = new ArrayList<>();
                for(EnderecoDTO end : dto.listaEndereco()){
                    Endereco endereco = new Endereco();
                    endereco.setRua(end.rua());
                    endereco.setNumero(end.numero());
                    endereco.setCidade(end.cidade());
                    endereco.setEstado(end.estado());
                    endereco.setCep(end.cep());
                    enderecos.add(endereco);
                } 

        return UsuarioResponseDTO.valueOf(usuario);
    }
    

    @Override
    @Transactional
    public void delete(Long id) {
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        return UsuarioResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        return null;
    }

    @Override
    public List<UsuarioResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha) {
        Usuario usuario = repository.findByLoginAndSenha(login, senha);
        if (usuario == null) 
            throw new ValidationException("login", "Login ou senha inválido");
        
        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findByLogin(String login) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null) 
            throw new ValidationException("login", "Login inválido");
        
        return UsuarioResponseDTO.valueOf(usuario);
    }
    
}
