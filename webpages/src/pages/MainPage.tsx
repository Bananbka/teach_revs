import Navigation from ".././components/Navigation";
import MainContent from ".././components/MainContent.tsx";
import ContentBlock from ".././components/ContentBlock.tsx";
import FigureComposition from ".././components/main_page/FigureComposition.tsx";
import WelcomeText from ".././components/main_page/WelcomeText.tsx";
import WhatIsBlock from ".././components/main_page/WhatIsBlock.tsx";
import WhyIsBlock from ".././components/main_page/WhyIsBlock.tsx";

function MainPage() {

    return (
        <div className="bg-background-950">
            <Navigation />
            <MainContent>
                <ContentBlock>
                    <div className='flex w-full'>
                        <WelcomeText/>
                        <FigureComposition/>
                    </div>
                </ContentBlock>
                <ContentBlock>
                    <WhatIsBlock/>
                </ContentBlock>
                <ContentBlock>
                    <WhyIsBlock/>
                </ContentBlock>
            </MainContent>
        </div>
    )

}

export default MainPage;