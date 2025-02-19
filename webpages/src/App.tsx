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
                    <div className='flex gap-5  w-full mt-[50px] relative'>
                        <div className='bg-background-900 flex flex-col flex-1 p-5 aspect-square rounded-2xl min-w-0 min-h-0 relative'>
                            <div className='flex gap-5 relative'>
                                <div className='flex-1 aspect-square bg-[url(teacher/blank-teacher-pick-1_1.png)] bg-cover bg-center rounded-full overflow-hidden'></div>
                                <div className='flex flex-4 items-center text-[24px] font-semibold overflow-hidden truncate whitespace-nowrap
                                after:content-[""] after:absolute after:right-0 after:w-1/2 after:h-full after:pointer-events-none after:bg-gradient-to-l after:from-background-900 after:to-transparent'>
                                    Punpun overflow overflowoverflowoverflowoverflow
                                </div>
                            </div>
                            <p className='mt-5 w-full overflow-hidden
                            after:content-[""] after:absolute after:bottom-0 after:left-0 after:w-full after:h-1/3 after:pointer-events-none after:rounded-b-2xl after:bg-gradient-to-t after:from-background-900 after:from-15% after:to-transparent
                            before:absolute before:block before:w-30 before:aspect-square before:bottom-0 before:left-0 before:bg-radial-[at_0%_100%] before:from-background-900 before:from-40% before:to-transparent'>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium delectus, doloremque eius eos et ipsam iure magnam neque perspiciatis ratione sit suscipit tempore temporibus ut veritatis? Eos eveniet libero temporibus! Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias architecto at atque commodi consequuntur deserunt dolorem ducimus explicabo minus nihil, nostrum odio praesentium quia repellendus reprehenderit soluta tempora temporibus? Minima!
                            </p>
                            <div className='bg-primary-500 border-12 border-background-950
                            w-30 absolute -bottom-5 -left-5 aspect-square rounded-full
                            '>
                                90
                            </div>
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