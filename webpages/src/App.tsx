import MainContent from "./components/MainContent.tsx";
import Navigation from "./components/Navigation.tsx";
import ContentBlock from "./components/ContentBlock.tsx";
import TeacherInfo from "./components/teacher_page/TeacherInfo.tsx";
import RecentFeedback from "./components/teacher_page/RecentFeedback.tsx";

export default function MyApp() {
    return (
        <div>
            <Navigation/>
            <MainContent>
                <ContentBlock>
                    <TeacherInfo/>
                </ContentBlock>
                <ContentBlock>
                    <RecentFeedback/>
                </ContentBlock>
            </MainContent>
        </div>
    );
}