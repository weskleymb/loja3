package br.senac.rn.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.rn.loja.model.Marca;

@Controller
@RequestMapping("marca")
public class MarcaController extends GenericController<Marca> {

<<<<<<< HEAD
	@Autowired
	private MarcaService service;
	
	@GetMapping
	public String lista(Model model) {
		List<Marca> marcas = service.buscarTodos();
		model.addAttribute("marcas", marcas);
		return "marca/lista";
	}
	
	@GetMapping("cadastrar")
	public String novo(Model model) {
		Marca marca = new Marca();
		model.addAttribute(marca);
		return "marca/form";
	}
	
	@GetMapping("editar/{id}")
	public String editar(@PathVariable("id") Integer id, Model model) {
		Marca marca = service.obterPorId(id);
		model.addAttribute(marca);
		return "marca/form";
	}
	
	@GetMapping("remover/{id}")
	public String remover(@PathVariable("id") Integer id, Model model) {
		service.remover(id);
		return "redirect:/marca";
	}
	
	@PostMapping
	public ModelAndView salvar(Marca marca) {
		service.salvar(marca);
		ModelAndView mav = new ModelAndView(new RedirectView("/marca", true));
		return mav;
=======
	@Override
	public Class<Marca> getClassType() {
		return Marca.class;
>>>>>>> 140f8d4281d9b7280dc0180297bd36716b4d78b6
	}
	
}
