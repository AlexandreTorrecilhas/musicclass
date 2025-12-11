import { HttpClient, HttpClientModule } from "@angular/common/http";
import { Component } from "@angular/core";
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";

@Component({
    selector: 'app-formulario-aluno',
    imports: [ReactiveFormsModule, HttpClientModule],
    standalone: true,
    templateUrl: './app-formulario-aluno.html',
    styleUrl: './app-formulario-aluno.css'
})
export class AppFormularioAluno{
    constructor(private http: HttpClient){};

    myForm = new FormGroup({
        nome: new FormControl('', Validators.required),
        dataNascimento: new FormControl('', Validators.required),
        estudante: new FormControl('', Validators.required),
        empregado: new FormControl('', Validators.required),
        teminstrumentodesejado: new FormControl('', Validators.required),
        email: new FormControl('', Validators.required),
        mensagem: new FormControl('')
    });

    // Function to handle form submission
    onSubmit() {
    // Check if the form is valid before submitting
    if (this.myForm.valid) {
const rawData = this.myForm.value;

        // Mapeamento para o formato esperado pelo Java/API
        const transformedData = {
            // Mapeamento direto de strings/dates
            nome: rawData.nome,
            dtNascimento: rawData.dataNascimento,
            email: rawData.email,
            mensagem: rawData.mensagem, 

            // 🌟 A CORREÇÃO: Converter a string 'Sim'/'Não' para o boolean true/false
            isEstudante: rawData.estudante === 'Sim',
            isEmpregado: rawData.empregado === 'Sim',
            temInstrumento: rawData.teminstrumentodesejado === 'Sim'
        };
        const endpoint = 'http://localhost:8080/api/pessoa'; // ⬅️ Replace with your actual endpoint

        // 3. Send the Information to the Endpoint
        this.http.post(endpoint, transformedData).subscribe({
        next: (response) => {
            console.log('Sucesso no envio:', response);
            alert('Formulário enviado com sucesso!');
            this.myForm.reset(); // Clear the form after success
        },
        error: (error) => {
            console.error('Erro ao enviar:', error);
            alert('Ocorreu um erro ao enviar o formulário. Tente novamente.');
        }
        });
    } else {
        alert('Por favor, preencha todos os campos obrigatórios corretamente.');
    }
    }
};