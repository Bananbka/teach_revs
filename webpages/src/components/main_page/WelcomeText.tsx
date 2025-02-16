import Button from "../Button.tsx";

const WelcomeText = () => {
    return (
        <div className='flex-col w-120 mt-10'>
            <h1 className='text-[60px] font-bold'>
                This is your time to <span className='text-primary-500'>rate</span> the teacher 🔥
            </h1>
            <h2 className='text-[32px] font-bold ml-auto w-fit mt-5'>
                🗣 <span className='opacity-60'>time to say it all...</span>
            </h2>
            <div className='flex gap-5 mt-10'>
                <Button onClick={()=>console.log("CLICK!")}>Go to rating!</Button>
                <Button onClick={()=>console.log("CLICK!")}>Go to rating!</Button>
            </div>
        </div>
    );
};

export default WelcomeText;