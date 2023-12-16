import { ReactNode, createContext, useState } from 'react';
import axios from 'axios';
import { Car } from '../types';

type AlucarContextType = {
    historico: Car[];
    setHistorico: React.Dispatch<React.SetStateAction<Car[]>>;
    getHistorico: () => Promise<void>;
};

interface AlucarProviderProps {
    children: ReactNode;
}

export const AlucarContext = createContext({} as AlucarContextType);

export function AlucarProvider({ children }: AlucarProviderProps) {
    
    const [historico, setHistorico] = useState<Car[]>([]);

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
