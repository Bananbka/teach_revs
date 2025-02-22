import RecentComment from "./RecentComment.tsx"

const RecentFeedback = () => {
    return (
        <div>
            <h2 className='font-bold text-[36px] mx-auto block w-fit'>
                Recent feedback
            </h2>
            <div className='flex gap-5  w-full mt-[50px] relative'>
                <RecentComment/>
                <RecentComment/>
                <RecentComment/>
            </div>
        </div>
    );
};

export default RecentFeedback;