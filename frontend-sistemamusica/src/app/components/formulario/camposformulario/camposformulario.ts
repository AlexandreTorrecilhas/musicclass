import { InterfaceFormulario } from "../../../interfaces/interfaceformulario/interfaceFormulario";

export const CAMPOSDOFORMULARIO:InterfaceFormulario = {
    linkApi: '/api/pessoa',
    secoes: [
                {
                    titulo: 'Dados Pessoais',
                    id: 'dadospessoais',
                    camposFormulario: [
                        { key: 'nome', label: 'Nome', type: 'text' },
                        { key: 'datanascimento', label: 'Data Nascimento', type: 'date' }
                    ]
                },
                {
                    titulo: 'Dados Administrativos',
                    id: 'dadosadministrativos',
                    camposFormulario: [
                        { key: 'estudante', label: 'Estudante', type: 'radio' },
                        { key: 'email', label: 'Email', type: 'email' }
                    ]
            }
        ]
}