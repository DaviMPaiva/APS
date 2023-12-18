import { ReactNode, createContext, useState } from 'react';
import axios from 'axios';
import { Car, Cartao, Reserva } from '../types';

type AlucarContextType = {
    historico: Reserva[];
    setHistorico: React.Dispatch<React.SetStateAction<Reserva[]>>;
    getHistorico: () => Promise<void>;
    pesquisaModelo: Car[];
    setPesquisaModelo: React.Dispatch<React.SetStateAction<Car[]>>;
    getCarroPorModelo: (modelo: string) => Promise<void>;
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
    const [pesquisaModelo, setPesquisaModelo] = useState<Car[]>([]);
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

    const getCarroPorModelo = async (modelo: string) => {   
        axios.get(`http://localhost:8080/pesquisar/pesquisarModelo/${modelo}`)
            .then((response) => {
                setPesquisaModelo(response.data);
                console.log(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    const reservarCarro = async (reserva: Reserva, cartao: Cartao) => {
        console.log(reserva, cartao);
        axios.post('http://localhost:8080/reserva/solicitaPagamento', {reserva, cartao})
            .then((response) => {
                setReservaConfirmada(response.data);
                console.log(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    return (
        <AlucarContext.Provider value={{ historico, setHistorico, getHistorico, pesquisaModelo, setPesquisaModelo, getCarroPorModelo, reservaConfirmada, setReservaConfirmada, reservarCarro }}>
            {children}
        </AlucarContext.Provider>
    );
}

export default AlucarProvider;
