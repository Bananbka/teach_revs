import Button from "./Button.tsx";

const Navigation = () => {
    return (
        <div className='flex items-center bg-background-950 border-b-1 border-text-100 w-full h-[60px]'>
            <div className='flex justify-between items-center w-full max-h-12 overflow-hidden mx-50'>
                <div className='flex items-center'>
                    <div className='h-12 w-12 bg-text-50 rounded-lg'></div>
                    <span className='text-text-50 mx-4 font-bold text-[20px]'>preachery</span>
                </div>
                <ul className='flex items-center order-last'>
                    <Button onClick={()=>console.log("CLICK!")}>
                        <h1>Login</h1>
                    </Button>
                </ul>
            </div>
        </div>
    );
};

export default Navigation;