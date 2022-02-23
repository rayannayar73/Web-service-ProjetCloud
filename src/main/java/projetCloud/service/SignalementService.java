package projetCloud.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import projetCloud.model.Signalement;
import projetCloud.repository.SignalementRepository;

@Service
public class SignalementService {

    @Autowired
    private SignalementRepository signalementRepository;

    public SignalementService(){}

    public Page<Signalement> findSignalement(Long type, Long etat, Date avant, Date apres, Pageable page){
        if(type!=null && etat!=null && avant!=null && apres!=null)return signalementRepository.findSignalementByAll(type, etat, avant, apres,page);
        if(type!=null && etat!=null && avant!=null && apres==null)return signalementRepository.findSignalementByAllBefore(type,etat,avant,page);
        if(type!=null && etat!=null && avant==null && apres!=null)return signalementRepository.findSignalementByAllAfter(type,etat,apres,page);
        if(type!=null && etat!=null && avant==null && apres==null)return signalementRepository.findSignalementByEtatAndType(type,etat,page);
        
        if(type!=null && etat==null && avant!=null && apres!=null)return signalementRepository.findSignalementByTypeAndDateRoa(type,avant,apres,page);
        if(type!=null && etat==null && avant!=null && apres==null)return signalementRepository.findSignalementByTypeBefore(type,avant,page);
        if(type!=null && etat==null && avant==null && apres!=null)return signalementRepository.findSignalementByTypeAfter(type,apres,page);
        if(type!=null && etat==null && avant==null && apres==null)return signalementRepository.findSignalementByType(type,page);

        if(etat!=null && type==null && avant!=null && apres!=null)return signalementRepository.findSignalementByEtatAndDateRoa(etat,avant,apres,page);
        if(etat!=null && type==null && avant!=null && apres==null)return signalementRepository.findSignalementByEtatBefore(etat,avant,page);
        if(etat!=null && type==null && avant==null && apres!=null)return signalementRepository.findSignalementByEtatAfter(etat,apres,page);
        if(etat!=null && type==null && avant==null && apres==null)return signalementRepository.findSignalementByEtat(etat,page);

        if(etat==null && type==null && avant!=null && apres!=null)return signalementRepository.findSignalementByDateRoa(avant,apres,page);
        if(etat==null && type==null && avant!=null && apres==null)return signalementRepository.findSignalementByDateAvant(avant,page);
        if(etat==null && type==null && avant!=null && apres==null)return signalementRepository.findSignalementByDateAvant(avant,page);
        
        else return signalementRepository.findAll(page);
    }
    public Page<Signalement> findSignalementByRegion(Long region, Long type, Long etat, Date avant, Date apres, Pageable page){
        if(type!=null && etat!=null && avant!=null && apres!=null)return signalementRepository.findWithRegionSignalementByAll(page, region,type, etat, avant, apres);
        if(type!=null && etat!=null && avant!=null && apres==null)return signalementRepository.findWithRegionSignalementByAllBefore(region,type,etat,avant, page);
        if(type!=null && etat!=null && avant==null && apres!=null)return signalementRepository.findWithRegionSignalementByAllAfter(region,type,etat,apres, page);
        if(type!=null && etat!=null && avant==null && apres==null)return signalementRepository.findWithRegionSignalementByEtatAndType(region,type,etat, page);
        
        if(type!=null && etat==null && avant!=null && apres!=null)return signalementRepository.findWithRegionSignalementByTypeAndDateRoa(region,type,avant,apres, page);
        if(type!=null && etat==null && avant!=null && apres==null)return signalementRepository.findWithRegionSignalementByTypeBefore(region,type,avant, page);
        if(type!=null && etat==null && avant==null && apres!=null)return signalementRepository.findWithRegionSignalementByTypeAfter(region,type,apres, page);
        if(type!=null && etat==null && avant==null && apres==null)return signalementRepository.findWithRegionSignalementByType(region,type, page);

        if(etat!=null && type==null && avant!=null && apres!=null)return signalementRepository.findWithRegionSignalementByEtatAndDateRoa(region,etat,avant,apres, page);
        if(etat!=null && type==null && avant!=null && apres==null)return signalementRepository.findWithRegionSignalementByEtatBefore(region,etat,avant, page);
        if(etat!=null && type==null && avant==null && apres!=null)return signalementRepository.findWithRegionSignalementByEtatAfter(region,etat,apres, page);
        if(etat!=null && type==null && avant==null && apres==null)return signalementRepository.findWithRegionSignalementByEtat(region,etat, page);

        if(etat==null && type==null && avant!=null && apres!=null)return signalementRepository.findWithRegionSignalementByDateRoa(region,avant,apres, page);
        if(etat==null && type==null && avant!=null && apres==null)return signalementRepository.findWithRegionSignalementByDateAvant(region,avant, page);
        if(etat==null && type==null && avant==null && apres!=null)return signalementRepository.findWithRegionSignalementByDateApres(region,apres, page);
        
        else return signalementRepository.findAll(page);
    }
    
}