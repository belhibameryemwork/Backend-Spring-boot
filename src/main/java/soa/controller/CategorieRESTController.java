package soa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Categorie;  // Assurez-vous d'importer la classe Categorie
import soa.repository.CategorieRepository;  // Assurez-vous d'importer le bon repository
@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/categories")  // Mettez à jour le chemin de base
public class CategorieRESTController {  // Mettez à jour le nom de la classe

    @Autowired
    private CategorieRepository categorieRepos;  // Assurez-vous d'injecter le bon repository

    @GetMapping(value = "/index")
    public String accueil() {
        return "Bienvenue au service Web REST 'categories'.....";
    }

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<Categorie> getAllCategories() {
        return categorieRepos.findAll();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Categorie getCategorie(@PathVariable Long id) {
        Categorie c = categorieRepos.findById(id).get();
        return c;
    }

    @GetMapping(value = "/delete/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieRepos.deleteById(id);
    }

    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Categorie saveCategorie(@RequestBody Categorie c) {
        return categorieRepos.save(c);
    }

    @PutMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Categorie updateCategorie(@RequestBody Categorie c) {
        return categorieRepos.save(c);
    }

    @DeleteMapping(value = "/")
    public void deleteCategorie(@RequestBody Categorie c) {
        categorieRepos.delete(c);
    }
}