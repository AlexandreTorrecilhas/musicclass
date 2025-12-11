import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { AppNavBar } from '../../barraNavegacao/app-nav-bar';
import { AppFormularioAluno } from '../formularioAluno/app-formulario-aluno';

//É crucial ter uma interface para os dados, seguindo a estrutura do seu backend
interface Pessoa {
  idPessoa: number;
  nome: string;
  dtNascimento: string; // Deve ser string no frontend para JSON
  isEstudante: boolean;
  isEmpregado: boolean;
  temInstrumento: boolean;
  email: string;
}

@Component({
  selector: 'app-gerenciar-alunos',
  standalone: true,
  // Adicionar todos os módulos necessários
  imports: [CommonModule, HttpClientModule, ReactiveFormsModule],
  templateUrl: './app-formulario-pesquisar-pessoas.html',
  styleUrl: './app-formulario-pesquisar-pessoas.css'
})
export class GerenciarAlunosComponent implements OnInit {

  // Variáveis de Estado
  alunos: Pessoa[] = [];
  alunoSelecionado: Pessoa | null = null;
  estaEditando: boolean = false;
  estaCarregando: boolean = true;
  apiUrl = 'http://localhost:8080/api/pessoa';

  // Formulário Reativo (para edição e novo cadastro)
  alunoForm = new FormGroup({
    nome: new FormControl('', Validators.required),
    dtNascimento: new FormControl('', Validators.required),
    isEstudante: new FormControl(false), // Inicializado como boolean
    isEmpregado: new FormControl(false),
    temInstrumento: new FormControl(false),
    email: new FormControl('', [Validators.required, Validators.email]),
  });

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.carregarAlunos();
  }

  // ------------------------------------------
  // GET: Listar Todos os Alunos
  // ------------------------------------------
  carregarAlunos() {
    this.estaCarregando = true;
    this.http.get<Pessoa[]>(this.apiUrl).subscribe({
      next: (data) => {
        this.alunos = data;
        this.estaCarregando = false;
      },
      error: (err) => {
        console.error('Erro ao carregar alunos:', err);
        this.estaCarregando = false;
      }
    });
  }

  // ------------------------------------------
  // Selecionar Aluno para Edição
  // ------------------------------------------
  selecionarAluno(aluno: Pessoa) {
    this.alunoSelecionado = aluno;
    this.estaEditando = true;
    
    // Preencher o formulário com os dados do aluno
    this.alunoForm.setValue({
      nome: aluno.nome,
      dtNascimento: aluno.dtNascimento,
      isEstudante: aluno.isEstudante,
      isEmpregado: aluno.isEmpregado,
      temInstrumento: aluno.temInstrumento,
      email: aluno.email,
    });
  }

  // ------------------------------------------
  // PUT: Atualizar Aluno
  // ------------------------------------------
  salvarEdicao() {
    if (this.alunoForm.valid && this.alunoSelecionado) {
      const alunoAtualizado = { 
          ...this.alunoForm.value, 
          idPessoa: this.alunoSelecionado.idPessoa 
      } as Pessoa;

      const updateUrl = `${this.apiUrl}/atualizarPessoa/${this.alunoSelecionado.idPessoa}`;
      
      this.http.put(updateUrl, alunoAtualizado).subscribe({
        next: () => {
          alert('Aluno atualizado com sucesso!');
          this.cancelarEdicao();
          this.carregarAlunos(); // Recarrega a lista
        },
        error: (err) => console.error('Erro ao atualizar aluno:', err)
      });
    }
  }

  // ------------------------------------------
  // DELETE: Remover Aluno
  // ------------------------------------------
  removerAluno(idPessoa: number) {
    if (confirm('Tem certeza de que deseja remover este aluno?')) {
      const deleteUrl = `${this.apiUrl}/removerPessoa/${idPessoa}`;
      
      this.http.delete(deleteUrl, { responseType: 'text' }).subscribe({
        next: (response) => {
          alert(response);
          this.carregarAlunos(); // Recarrega a lista
        },
        error: (err) => console.error('Erro ao remover aluno:', err)
      });
    }
  }

  // ------------------------------------------
  // Resetar a Edição
  // ------------------------------------------
  cancelarEdicao() {
    this.alunoSelecionado = null;
    this.estaEditando = false;
    this.alunoForm.reset();
  }
  
  // Função auxiliar para exibir booleanos
  getSimNao(valor: boolean): string {
    return valor ? 'Sim' : 'Não';
  }
}