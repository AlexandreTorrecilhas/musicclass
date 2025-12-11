import { Routes } from '@angular/router';
import { AppPaginaMain } from './paginas/app-pagina-main';
import { AppPaginaCadastroAluno } from './paginas/paginaCadastroAluno/app-pagina-cadastro-aluno';
import { AppPaginaConsultarPessoas } from './paginas/paginaConsultarPessoas/app-pagina-consultar-pessoas';

export const routes: Routes = [
    {path: '', component: AppPaginaMain},
    {path: 'cadastroAluno', component: AppPaginaCadastroAluno},
    {path: 'consultaPessoas', component: AppPaginaConsultarPessoas}
];
