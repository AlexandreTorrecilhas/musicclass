export interface InterfaceCamposFormulario{
    key: string,
    label: string,
    type: 'text' | 'date' | 'radio' | 'checkbox' | 'email' | 'number'
    options?: []
}