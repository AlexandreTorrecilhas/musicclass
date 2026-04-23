import { InterfaceFormulario } from "../../../interfaces/interfaceformulario/interfaceFormulario";

export const PESSOACAMPOSDOFORMULARIO:InterfaceFormulario = {
    linkApi: 'http://localhost:8080/api/pessoa',
    secoes: [
                {
                    titulo: 'Dados Pessoais',
                    id: 'dadospessoais',
                    camposFormulario: [
                        { key: 'nome', label: 'Nome', type: 'text' },
                        { key: 'dtNascimento', label: 'Data Nascimento', type: 'date' }
                    ]
                },
                {
                    titulo: 'Dados Administrativos',
                    id: 'dadosadministrativos',
                    camposFormulario: [
                        { key: 'isEstudante', label: 'Estudante', type: 'checkbox', value: "true" },
                        { key: 'isEmpregado', label: 'Voluntário', type: 'checkbox', value: "true" },
                        { key: 'isResponsavel', label: 'Responsavel', type: 'checkbox', value: "true" },
                        { key: 'email', label: 'Email', type: 'email' }
                    ]
            }
        ]
}