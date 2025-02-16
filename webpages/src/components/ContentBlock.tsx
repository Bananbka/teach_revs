import {ReactNode} from "react";


interface Props {
    children: ReactNode;
}

const ContentBlock = ({children}:Props) => {
    return (
        <div className='mt-25'>
            {children}
        </div>
    );
};

export default ContentBlock;