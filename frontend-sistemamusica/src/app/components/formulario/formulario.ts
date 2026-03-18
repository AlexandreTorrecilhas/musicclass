import { Component } from "@angular/core";
import { InterfaceFormulario } from "../../interfaces/interfaceformulario/interfaceFormulario";
import { CommonModule } from "@angular/common";
import { CAMPOSDOFORMULARIO } from "./camposformulario/camposformulario";
import { ReactiveFormsModule } from "@angular/forms";

@Component({
    selector: 'formulario-pessoa',
    standalone: true,
    imports: [CommonModule, ReactiveFormsModule],
    templateUrl: './formulario.html',
    styleUrl: './formulario.css'
})
export class FormularioPessoa {
    public readonly camposFormulario:InterfaceFormulario = CAMPOSDOFORMULARIO;
}