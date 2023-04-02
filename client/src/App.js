import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Login from "./Pages/Login/Login";
import Join from "./Pages/Join/Join";
import Main from "./Pages/Main/Main";
import ClassCategory from "./Pages/Class/ClassCategory/ClassCategory";
import Class from "./Pages/Class/Class/Class";
import RecommendClass from "./Pages/RecommendClass/RecommendClass";
import NoteSend from "./Pages/Note/NoteSend";
import NoteList from "./Pages/Note/NoteList";
import NoteDetail from "./Pages/Note/NoteDetail";
import Notice from "./Pages/Notice/Notice";
import MyClass from "./Pages/MyClass/MyClass";
import MyPage from "./Pages/MyPage/MyPage";
import Setting from "./Pages/Setting/Setting";
import StudentList from "./Pages/StudentList/StudentList";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/join" element={<Join />} />
          <Route path="/main" element={<Main />} />
          <Route path="/classCategory" element={<ClassCategory />} />
          <Route path="/class" element={<Class />} />
          <Route path="/aiClass" element={<RecommendClass />} />
          <Route path="/noteSend" element={<NoteSend />} />
          <Route path="/noteList" element={<NoteList />} />
          <Route path="/noteDetail" element={<NoteDetail />} />
          <Route path="/notice" element={<Notice />} />
          <Route path="/myClass" element={<MyClass />} />
          <Route path="/myPage" element={<MyPage />} />
          <Route path="/setting" element={<Setting />} />
          <Route path="/studentList" element={<StudentList />} />
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
