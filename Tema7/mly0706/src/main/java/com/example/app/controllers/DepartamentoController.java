package com.example.app.controllers;

import com.example.app.entity.Departamento;
import com.example.app.service.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/depto")
    public class DepartamentoController {

    @Autowired
    public DepartamentoService departamentoService;
    @GetMapping({ "/", "/list" })
    public String showList(Model model) {
        model.addAttribute("listaDepartamentos", departamentoService.obtenerTodos());
        return "departamento/listView";
    }
    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("departamentoForm", new Departamento());
        return "departamento/newFormView";
    }
    @PostMapping("/new/submit")
    public String showNewSubmit( @Valid Departamento departamentoForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "redirect:/depto/new";
        departamentoService.agregar(departamentoForm);
        return "redirect:/depto/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {

            departamentoService.borrar(departamentoService.obtenerPorId(id));

        return "redirect:/depto/list";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Departamento departamento = departamentoService.obtenerPorId(id);
        if (departamento != null) {
            model.addAttribute("departamentoForm", departamento);
            return "departamento/editFormView";
        } else {
            return "redirect:/depto/list";
        }
    }
    @PostMapping("/edit/submit")
    public String showEditSubmit( @Valid Departamento departamentoForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors())
            departamentoService.editar(departamentoForm);
        return "redirect:/depto/list";
    }
}



