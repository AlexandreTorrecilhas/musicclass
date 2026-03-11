import { Routes } from '@angular/router';
import { AppPaginaMain } from './paginas/app-pagina-main';
import { AppPaginaCadastroAluno } from './paginas/paginaCadastroAluno/app-pagina-cadastro-aluno';
//a - Here the object is been imported
import { AppPaginaConsultarPessoas } from './paginas/paginaConsultarPessoas/app-pagina-consultar-pessoas';

export const routes: Routes = [
    {path: '', component: AppPaginaMain},
    //An empty path means it is the index, the first one that will be loaded when the application is started
    {path: 'cadastroAluno', component: AppPaginaCadastroAluno},
    //Here I created a fake path. It isn't necessary to use allThePath/cadastroAluno. Angular automatically does it.
    //The fake path is connected to the object AppPaginaCadastroAluno
    {path: 'consultaPessoas', component: AppPaginaConsultarPessoas}
];
