import { useState, useEffect, useRef } from "react";

interface Props {
    name: string;
    comment: string;
    rate: number;
    
}

const RecentComment = ({ name, comment, rate } : Props) => {

    const ref = useRef<HTMLDivElement>(null);
    const [isOverflowing, setIsOverflowing] = useState<boolean>(false);

    useEffect( () => {
        const checkOverflow = () => {
            if (ref.current) {
                setIsOverflowing(ref.current.scrollWidth > ref.current.clientWidth);
            }
        };

        checkOverflow();
        window.addEventListener("resize", checkOverflow);
        return () => {window.removeEventListener("resize", checkOverflow)};
    }, []);

    return (
        <div className='bg-background-900 flex flex-col flex-1 p-5 aspect-square rounded-2xl min-w-0 min-h-0 relative'>
            <div className='flex gap-5 relative'>
                <div className='flex-1 aspect-square bg-[url(teacher/blank-teacher-pick-1_1.png)] bg-cover bg-center rounded-full overflow-hidden'></div>
                <div ref = {ref}
                     className={`flex flex-4 items-center text-[24px] font-semibold overflow-hidden truncate whitespace-nowrap
                                ${isOverflowing ? "after:content-[\"\"] after:absolute after:right-0 after:w-1/2 after:h-full after:pointer-events-none after:bg-gradient-to-l after:from-background-900 after:to-transparent" : ""}`}>
                    {name}
                </div>
            </div>
            <p className='mt-5 w-full overflow-hidden
                            after:content-[""] after:absolute after:bottom-0 after:left-0 after:w-full after:h-1/3 after:pointer-events-none after:rounded-b-2xl after:bg-gradient-to-t after:from-background-900 after:from-15% after:to-transparent
                            before:absolute before:block before:w-30 before:aspect-square before:bottom-0 before:left-0 before:bg-radial-[at_0%_100%] before:from-background-900 before:from-40% before:to-transparent'>
                {comment}
            </p>
            <div className='flex justify-center items-center
                            bg-primary-500 border-12 border-background-950
                            w-30 absolute -bottom-5 -left-5 aspect-square rounded-full
                            font-bold text-[40px]
                            '>
                {rate}
            </div>
        </div>
    );
};

export default RecentComment;
