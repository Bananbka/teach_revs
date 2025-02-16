const WhyIsBlock = () => {
    return (
        <div>
            <h2 className='font-bold text-[36px] mx-auto block w-fit'>
                Why is preachery?
            </h2>
            <div className='grid grid-cols-3 grid-rows-2 gap-5 w-full mt-[50px]'>
                <div className='bg-primary-500 rounded-2xl col-start-1 col-span-2 row-start-1'></div>
                <div className='bg-secondary-500 rounded-2xl col-start-3 row-start-1 row-span-2'></div>
                <div className='bg-accent-500 rounded-2xl aspect-square col-start-1 row-start-2'></div>
                <div className='bg-text-50 rounded-2xl aspect-square col-start-2 row-start-2'></div>
            </div>
        </div>
    );
};

export default WhyIsBlock;