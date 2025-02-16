
const FigureComposition = () => {
    return (
        <div className='ml-auto'>
            <div className='grid grid-cols-5 grid-rows-5 gap-4 w-md'>
                <div className='bg-primary-600 aspect-square rounded-2xl col-start-4 col-span-2 row-start-1 row-span-2'></div>
                <div className='bg-primary-600 aspect-square rounded-2xl col-start-1 col-span-2 row-start-2 row-span-2'></div>
                <div className='bg-secondary-400 aspect-square rounded-2xl col-start-3 row-start-2'></div>
                <div className='bg-primary-600 aspect-square rounded-2xl col-start-3 col-span-2 row-start-3 row-span-2'></div>
                <div className='bg-accent-600 rounded-2xl col-start-5 row-start-3 row-span-2'></div>
                <div className='bg-secondary-400 rounded-2xl col-start-2 row-start-4 row-span-2'></div>
                <div className='bg-accent-600 aspect-square rounded-2xl col-start-3 row-start-5'></div>
            </div>
        </div>
    );
};

export default FigureComposition;