import {ReactNode} from "react";

interface Props {
    children: ReactNode;
}

const MainContent = ({children}: Props) => {
    return (
        <div className='flex flex-col mx-50'>
                {children}
        </div>
    );
};

export default MainContent;