import { Component, OnInit } from "@angular/core";
import { InterfaceFormulario } from "../../interfaces/interfaceformulario/interfaceFormulario";
import { CommonModule } from "@angular/common";
import { PESSOACAMPOSDOFORMULARIO } from "./camposformulario/pessoaCamposformulario";
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from "@angular/forms";
import { Pessoa } from "../../services/pessoa";

@Component({
    selector: 'formulario-pessoa',
    standalone: true,
    imports: [CommonModule, ReactiveFormsModule,FormsModule],
    templateUrl: './formulario.html',
    styleUrl: './formulario.css'
})
export class FormularioPessoa implements OnInit{
    public readonly camposFormulario: InterfaceFormulario = PESSOACAMPOSDOFORMULARIO;
    public meuFormulario !: FormGroup;


    constructor(
        private fb: FormBuilder,
        private pessoaService: Pessoa
    ){}

    ngOnInit(): void {
        this.inicializarFormulario();
    }

private inicializarFormulario(): void {
    const group: any = {};

    this.camposFormulario.secoes.forEach(secao => {
        secao.camposFormulario.forEach(campo => {
            if (campo.type === 'checkbox') {
                group[campo.key] = [false]; // ✅ important
            } else {
                group[campo.key] = [''];
            }
        });
    });

    this.meuFormulario = this.fb.group(group);
}

    onSubmit(): void {
        console.log(this.meuFormulario.value);
        if (this.meuFormulario.valid) {
        const formValue = this.meuFormulario.value;

        const payload = {
            nome: formValue.nome,
            dtNascimento: formValue.dtNascimento,
            email: formValue.email,
            empregado: formValue.isEmpregado,
            estudante: formValue.isEstudante ,
            responsavel: formValue.isResponsavel
        };

            const endpoint = this.camposFormulario.linkApi; // Uses '/api/pessoa'

            this.pessoaService.enviarDados(endpoint, payload).subscribe({
                next: (response: any) => {
                    console.log('Success!', response);
                    alert('Data sent successfully to Oracle!');
                },
                error: (err: any) => {
                    console.error('Error sending data', err);
                }
            });
        }
    }

}