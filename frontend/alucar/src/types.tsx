export interface Car {
    placa: string;
    modelo: string;
    preco: number;
    ano: number;
    combustivel: string;
    transmissao: string;
    linkFotos: string;
}

export interface Reserva {
    valor: number;
    carro: string;
    dataInicio: string;
    dataTermino: string;
    taxa: number;
    usuario: string;
}

export interface Usuario {
    nome: string;
    email: string;
    senha: string;
    cartao: number;
}

export interface Cartao {
    numero: string;
    titular: string;
    dataValidade: string;
    cvc: string;
}