import { ReactNode, createContext, useState } from 'react';
import axios from 'axios';

type AlucarContextType = {
    imageLink: string;
    setImageLink: React.Dispatch<React.SetStateAction<string>>;
    getImageLink: () => Promise<void>;
};

interface AlucarProviderProps {
    children: ReactNode;
}

export const AlucarContext = createContext({} as AlucarContextType);

export function AlucarContextProvider({ children }: AlucarProviderProps) {
    
    const [imageLink, setImageLink] = useState<string>('');

    const getImageLink = async () => {
        axios.get('https://localhost:5000/')
            .then((response) => {
                setImageLink(response.data[0].url);
            })
            .catch((error) => {
                console.error(error);
            });
    }

    return (
        <AlucarContext.Provider value={{ imageLink, setImageLink, getImageLink }}>
            {children}
        </AlucarContext.Provider>
    );
};

export default AlucarContextProvider;
