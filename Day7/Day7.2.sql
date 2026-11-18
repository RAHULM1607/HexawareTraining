-- select p.patient_name,t.treatment_name,t.doctor_name,t.treatment_cost,t.treatment_cost from patients p inner join treatments t on p.patient_id=t.patient_id;
-- select  p.patient_name,t.treatment_name,t.doctor_name,t.treatment_cost,t.treatment_cost from patients p right join treatments t on p.patient_id=t.patient_id;
 select p.patient_name,t.treatment_name from patients p cross join treatments t;
  select p.patient_id,p.patient_name,count(t.treatment_id) as total_treatments from patients p left join treatments t on p.patient_id=t.patient_id group by p.patient_id,p.patient_name;
  select disease from patients group by disease having count(patient_id)>2;
 select p.patient_id,p.patient_name from patients p inner join treatments t on p.patient_id=t.patient_id group by p.patient_id,p.patient_name having count(t.treatment_id)>2;
  select p.patient_name from patients p inner join -- treatments t on p.patient_id=t.patient_id group by p.patient_id having sum(t.treatment_cost)>10000
  select doctor_name,sum(treatment_cost) as total_revenue from treatments  group by doctor_name order by total_revenue desc limit 1;
  select p.patient_id,p.patient_name from patients p inner join treatments t on p.patient_id=t.patient_id where t.treatment_name in ("blood test","insulin theraphy") group by p.patient_id,p.patient_name having count(distinct t.treatment_name)=2;
  select p.patient_id,p.patient_name,p.admission_date,t.treatment_date from patients p inner join treatments t on p.patient_id=t.patient_id where p.admission_date >='2026-01-01' and p.admission_date<'2026-02-01' and t.treatment_date >='2026-02-01' and t.treatment_date<'2026-03-01';
  select treatment_cost from treatments order by treatment_cost desc limit 1 offset 1;
  select disease,count(patient_id) as total_patients from patients group by disease order by total_patients desc limit 3;
 select doctor_name,count(patient_id) as total_patients from treatments group by doctor_name having count(distinct patient_id)>2;
 