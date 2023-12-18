import { ReactNode, createContext, useState } from 'react';
import axios from 'axios';
import { Car, Cartao, Reserva } from '../types';

type AlucarContextType = {
    historico: Reserva[];
    setHistorico: React.Dispatch<React.SetStateAction<Reserva[]>>;
    getHistorico: () => Promise<void>;
    pesquisaCarros: Car[];
    setPesquisaCarros: React.Dispatch<React.SetStateAction<Car[]>>;
    getCarrosDisponiveis: (dataInicio: string, dataTermino: string) => Promise<void>;
    reservaConfirmada: boolean;
    setReservaConfirmada: React.Dispatch<React.SetStateAction<boolean>>;
    reservarCarro: ( reserva: Reserva, cartao: Cartao ) => Promise<void>;
};

interface AlucarProviderProps {
    children: ReactNode;
}

export const AlucarContext = createContext({} as AlucarContextType);

export function AlucarProvider({ children }: AlucarProviderProps) {
    
    const [historico, setHistorico] = useState<Reserva[]>([]);
    const [pesquisaCarros, setPesquisaCarros] = useState<Car[]>([]);
    const [reservaConfirmada, setReservaConfirmada] = useState(false);

    const getHistorico = async () => {
        axios.get('http://localhost:8080/historico/visualizarHistorico')
            .then((response) => {
                setHistorico(response.data);
                console.log(response.data);
                
            })
            .catch((error) => {
                console.error(error);
            });
    }

    const getCarrosDisponiveis = async (dataInicio: string, dataTermino: string) => {   
        axios.get(`http://localhost:8080/pesquisar/pesquisarModelo/${dataInicio}/${dataTermino}`)
            .then((response) => {
                setPesquisaCarros(response.data);
                console.log(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    const reservarCarro = async (reserva: Reserva, cartao: Cartao) => {
        console.log(reserva, cartao);
        axios.post('http://localhost:8080/reserva/validaReserva', {reserva, cartao})
            .then((response) => {
                setReservaConfirmada(response.data);
                console.log(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    return (
        <AlucarContext.Provider value={{ historico, setHistorico, getHistorico, pesquisaCarros, setPesquisaCarros, getCarrosDisponiveis, reservaConfirmada, setReservaConfirmada, reservarCarro }}>
            {children}
        </AlucarContext.Provider>
    );
}

export default AlucarProvider;
