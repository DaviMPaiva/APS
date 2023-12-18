import { ReactNode, createContext, useState } from 'react';
import axios from 'axios';
import { Reserva, Usuario } from '../types';

type AlucarContextType = {
    historico: Reserva[];
    setHistorico: React.Dispatch<React.SetStateAction<Reserva[]>>;
    getHistorico: () => Promise<void>;
    user: string;
    setUser: React.Dispatch<React.SetStateAction<string>>;
};

interface AlucarProviderProps {
    children: ReactNode;
}

export const AlucarContext = createContext({} as AlucarContextType);

export function AlucarProvider({ children }: AlucarProviderProps) {

    const [historico, setHistorico] = useState<Reserva[]>([]);
    const [user, setUser] = useState<string>('joao@email.com');
        

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

    return (
        <AlucarContext.Provider value={{ historico, setHistorico, getHistorico }}>
            {children}
        </AlucarContext.Provider>
    );
};

export default AlucarProvider;
