import MainContent from "./components/MainContent.tsx";
import Navigation from "./components/Navigation.tsx";
import ContentBlock from "./components/ContentBlock.tsx";

export default function MyApp() {
    return (
        <div>
            <Navigation/>
            <MainContent>
                <ContentBlock>
                    <div className="flex">
                        <div className="aspect-3/4 bg-[url(teacher/blank-teacher-pick-3_4.png)] bg-cover bg-center w-[300px] rounded-xl"/>
                        <div className="flex flex-col flex-1 ml-5 gap-5 rounded-xl">
                            <div className="bg-secondary-800 w-full px-5 py-2 font-bold text-[36px] rounded-xl">
                                Yuuichi Onodera
                            </div>
                            <div className="bg-secondary-900 w-full px-5 py-2 text-[16px] rounded-xl">
                                Tokyo Art College
                            </div>
                            <div className="w-full flex flex-nowrap gap-5 text-[28px] font-semibold relative">
                                <div className="bg-secondary-800 px-5 py-2  rounded-xl">
                                    💬 31
                                </div>
                                <div className="bg-secondary-800 px-5 py-2 flex justify-center items-center rounded-xl aspect-square shrink-5">
                                    B
                                </div>
                                <div className="bg-secondary-800 px-5 py-2 rounded-xl">
                                    Good
                                </div>
                                <div className="bg-secondary-800 flex p-6 text-[36px] border-8 border-background-950 justify-center items-center aspect-square rounded-full font-bold absolute right-0 -top-[50%] ">
                                    100
                                </div>
                            </div>
                            <div className="bg-secondary-800 flex flex-wrap justify-center items-center gap-5 p-5 rounded-xl h-full">
                                <div className="bg-primary-700 w-1/4 overflow-hidden flex justify-center items-center px-5 py-2 rounded-xl text-[20px] font-semibold">
                                    Justify
                                </div>
                                <div className="bg-primary-700 w-1/4 overflow-hidden flex justify-center items-center px-5 py-2 rounded-xl text-[20px] font-semibold">
                                    Sigmaboy
                                </div>
                                <div className="bg-primary-700 w-1/4 overflow-hidden flex justify-center items-center px-5 py-2 rounded-xl text-[20px] font-semibold">
                                    Real skibidi
                                </div>
                                <div className="bg-primary-700 w-1/4 overflow-hidden flex justify-center items-center px-5 py-2 rounded-xl text-[20px] font-semibold">
                                    DILF
                                </div>
                                <div className="bg-primary-700 w-1/4 overflow-hidden flex justify-center items-center px-5 py-2 rounded-xl text-[20px] font-semibold">
                                    BD
                                </div>
                                <div className="bg-primary-700 flex justify-center items-center p-2 rounded-xl text-[20px] font-semibold w-12 aspect-square">
                                    +
                                </div>
                            </div>
                        </div>
                    </div>
                </ContentBlock>
                <ContentBlock>
                    <h2 className='font-bold text-[36px] mx-auto block w-fit'>
                        Recent feedback
                    </h2>
                    <div className='flex gap-5  w-full mt-[50px]'>
                        <div className='bg-background-900 flex flex-col flex-1 p-5 aspect-square rounded-2xl min-w-0'>
                            <div className='flex gap-5 relative'>
                                <div className='flex-1 aspect-square bg-[url(teacher/blank-teacher-pick-1_1.png)] bg-cover bg-center rounded-full overflow-hidden'></div>
                                <div className='flex flex-4 items-center text-[24px] font-semibold overflow-hidden truncate whitespace-nowrap
                                after:content-[""] after:absolute after:right-0 after:w-1/2 after:h-full after:pointer-events-none after:bg-gradient-to-l after:from-background-900 after:to-transparent'>
                                    Punpun overflow overflowoverflowoverflowoverflow
                                </div>
                            </div>
                            <div></div>
                        </div>
                        <div className='bg-background-900 flex flex-col flex-1 p-5 aspect-square rounded-2xl'>
                            <div className='flex gap-5'>
                                <div className='flex-1 aspect-square bg-[url(teacher/blank-teacher-pick-1_1.png)] bg-cover bg-center rounded-full overflow-hidden'></div>
                                <div className='flex flex-4 flex-nowrap items-center text-[24px] font-semibold overflow-hidden truncate whitespace-nowrap'>
                                    Punpun overflow
                                </div>
                            </div>
                            <div></div>
                        </div>
                        <div className='bg-background-900 flex flex-col flex-1 p-5 aspect-square rounded-2xl'>
                            <div className='flex gap-5'>
                                <div className='flex-1 aspect-square bg-[url(teacher/blank-teacher-pick-1_1.png)] bg-cover bg-center rounded-full overflow-hidden'></div>
                                <div className='flex flex-4 flex-nowrap items-center text-[24px] font-semibold overflow-hidden truncate whitespace-nowrap'>
                                    Punpun overflow
                                </div>
                            </div>
                            <div></div>
                        </div>
                    </div>
                </ContentBlock>
            </MainContent>
        </div>
    );
}