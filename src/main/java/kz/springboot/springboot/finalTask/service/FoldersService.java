package kz.springboot.springboot.finalTask.service;

import kz.springboot.springboot.finalTask.model.Folders;
import kz.springboot.springboot.finalTask.repository.FoldersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoldersService {

    private final FoldersRepository foldersRepository;

    public List<Folders> getAllFolders(){
        List<Folders> folders = foldersRepository.findAll();
        return folders;
    }

    public void saveFolder(Folders folder){
        foldersRepository.save(folder);
    }

    public Folders getFolderById(Long id){
        return foldersRepository.findById(id).orElseThrow();
    }

    public void deleteFolder(Long id){
        foldersRepository.deleteById(id);
    }
}
