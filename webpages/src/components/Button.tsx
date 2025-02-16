import {ReactNode} from "react";

interface Props {
    children: ReactNode;
    onClick: () => void;
}

const Button = ({children, onClick} : Props) => {
    return (
        <button className={`bg-secondary-500 hover:bg-secondary-600 active:bg-secondary-700 transition duration-200 hover:drop-shadow-[0_2px_13px_var(--color-secondary-600)] active:drop-shadow-[0_2px_10px_var(--color-secondary-700)] px-10 py-2 rounded-lg text-text-50 font-semibold text-[20px]`}
                onClick={onClick}>
            {children}
        </button>
    );
};

export default Button;